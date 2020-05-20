/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.showcase.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.primefaces.component.schedule.Schedule;

/**
 * Provides the examples for the [@code extender} options of various components,
 * such as the {@link Schedule}.
 */
@Named
@ApplicationScoped
public class ExtenderService {

	public Map<String, ExtenderExample> createExtenderExamples() {
		final Properties properties = new Properties();

		try (final InputStream inStream = ExtenderService.class
				.getResourceAsStream("/schedule-extender-examples.properties")) {
			properties.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		final Map<String, ExtenderExample> extenderExamples = new HashMap<>();

		for (final String key : properties.stringPropertyNames()) {
			if (key != null && key.endsWith(".name")) {
				final String baseKey = key.substring(0, key.length() - 5);
				final ExtenderExample example = new ExtenderExample(baseKey, properties);
				if (example.getName() != null && example.getValue() != null && !example.getName().trim().isEmpty()
						&& !example.getValue().trim().isEmpty()) {
					extenderExamples.put(baseKey, example);
				}
			}
		}

		return extenderExamples;
	}

	public static class ExtenderExample {
		private final String details;
		private final String html;
		private final String key;
		private final String link;
		private final String name;
		private final String value;

		public ExtenderExample(String key, Properties properties) {
			this.key = key;
			this.details = properties.getProperty(key + ".details");
			this.html = properties.getProperty(key + ".html");
			this.link = properties.getProperty(key + ".link");
			this.name = properties.getProperty(key + ".name");
			this.value = properties.getProperty(key + ".value");
		}

		public String getDetails() {
			return details;
		}
		
		public String getHtml() {
			return html;
		}

		public String getKey() {
			return key;
		}

		public String getLink() {
			return link;
		}

		public String getName() {
			return name;
		}

		public String getValue() {
			return value;
		}
	}
}