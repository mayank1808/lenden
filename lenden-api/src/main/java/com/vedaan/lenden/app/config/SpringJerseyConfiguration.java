package com.vedaan.lenden.app.config;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.ParameterNameProvider;
import javax.validation.Validation;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.ContextResolver;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.validation.ValidationConfig;
import org.glassfish.jersey.server.validation.internal.InjectingConstraintValidatorFactory;

import com.wordnik.swagger.config.ConfigFactory;
import com.wordnik.swagger.config.ScannerFactory;
import com.wordnik.swagger.config.SwaggerConfig;
import com.wordnik.swagger.jaxrs.config.ReflectiveJaxrsScanner;
import com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider;
import com.wordnik.swagger.jaxrs.listing.ApiListingResource;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;
import com.wordnik.swagger.jaxrs.listing.ResourceListingProvider;
import com.wordnik.swagger.jaxrs.reader.DefaultJaxrsApiReader;
import com.wordnik.swagger.reader.ClassReaders;

/**
 * @author mayank
 *
 */

public class SpringJerseyConfiguration extends ResourceConfig {

	private static final String PACKAGES_TO_SCAN_FOR_APIS = "com.vedaan.lenden";
	private static final String API_VERSION = "1.0";

	// Register all required properties and class
	public SpringJerseyConfiguration() {

		packages(PACKAGES_TO_SCAN_FOR_APIS);
		registerSwagger();
		registerValidationProperties();
		// Jackson Feature for JSON <=> POJO
		register(JacksonFeature.class);
		register(MultiPartFeature.class);
	}

	@PostConstruct
	/**
	 * Initializes Swagger Configuration
	 */
	public void initializeSwaggerConfiguration() {

		final ReflectiveJaxrsScanner scanner = new ReflectiveJaxrsScanner();
		scanner.setResourcePackage(PACKAGES_TO_SCAN_FOR_APIS);
		ScannerFactory.setScanner(scanner);
		ClassReaders.setReader(new DefaultJaxrsApiReader());
		final SwaggerConfig config = ConfigFactory.config();
		config.setApiVersion(API_VERSION);
		config.setBasePath("/lenden-api");
	}

	/**
	 * Here we register all the properties and class which are required for
	 * swagger integration
	 */
	private void registerSwagger() {
		register(ApiListingResource.class);
		register(ApiDeclarationProvider.class);
		register(ApiListingResourceJSON.class);
		register(ResourceListingProvider.class);
	}

	/**
	 * Here we register all the properties and class which are required for bean
	 * validation
	 */
	private void registerValidationProperties() {

		// Now you can expect validation errors to be sent to the client.
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

		// @ValidateOnExecution annotations on subclasses won't cause errors.
		property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);

		register(ValidationConfigurationContextResolver.class);
	}

	/**
	 * Inner class for validation configuration
	 * 
	 */
	public static class ValidationConfigurationContextResolver implements ContextResolver<ValidationConfig> {
		@Context
		private ResourceContext resourceContext;

		@Override
		public ValidationConfig getContext(final Class<?> type) {
			final ValidationConfig config = new ValidationConfig();
			config.constraintValidatorFactory(resourceContext.getResource(InjectingConstraintValidatorFactory.class));
			config.parameterNameProvider(new CustomParameterNameProvider());
			return config;
		}

		/**
		 * See ContactCardTest#testAddInvalidContact.
		 */
		private class CustomParameterNameProvider implements ParameterNameProvider {

			private final ParameterNameProvider nameProvider;

			public CustomParameterNameProvider() {
				nameProvider = Validation.byDefaultProvider().configure().getDefaultParameterNameProvider();
			}

			@Override
			public List<String> getParameterNames(final Constructor<?> constructor) {
				return nameProvider.getParameterNames(constructor);
			}

			@Override
			public List<String> getParameterNames(final Method method) {
				// See ContactCardTest#testAddInvalidContact.
				if ("addContact".equals(method.getName())) {
					return Arrays.asList("contact");
				}
				return nameProvider.getParameterNames(method);
			}
		}
	}
}
