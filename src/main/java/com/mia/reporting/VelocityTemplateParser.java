package com.mia.reporting;

import java.io.StringWriter;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VelocityTemplateParser {

	@Autowired
	private VelocityEngine velocityEngine;

	public String generateHTML(Map<String, Object> data, String report) {
		Template template = velocityEngine.getTemplate("templates/sample.vm");
		
		VelocityContext context = new VelocityContext();
		context.put("name", "Sakshith");
		
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        return writer.toString();
	}
}
