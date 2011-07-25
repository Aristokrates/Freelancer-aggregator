/*
 * Copyright 2010-2011 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.google.code.linkedinapi.client.examples;

import java.text.MessageFormat;
import java.util.EnumSet;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.google.code.linkedinapi.client.CompaniesApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.CompanyField;
import com.google.code.linkedinapi.client.enumeration.ProductField;
import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.Product;
import com.google.code.linkedinapi.schema.Products;

/**
 * @author Nabeel Mukhtar
 *
 */
public class CompaniesApiExample {

    /**
     * Consumer Key
     */
    private static final String CONSUMER_KEY_OPTION = "consumerKey";
	
    /**
     * Consumer Secret
     */
    private static final String CONSUMER_SECRET_OPTION = "consumerSecret";
    
    /**
     * Access Token
     */
    private static final String ACCESS_TOKEN_OPTION = "token";
	
    /**
     * Access Token Secret
     */
    private static final String ACCESS_TOKEN_SECRET_OPTION = "tokenSecret";

    /**
     * ID
     */
    private static final String ID_OPTION = "id";
    
    /**
     * Name of the help command line option.
     */
    private static final String HELP_OPTION = "help";
    
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		Options options = buildOptions();
        try {
            CommandLine line = new BasicParser().parse(options, args);
            processCommandLine(line, options);
        } catch(ParseException exp ) {
            System.err.println(exp.getMessage());
            printHelp(options);
        }
	}
	
    /**
     * Process command line options and call the service. 
     */
    private static void processCommandLine(CommandLine line, Options options) {
        if(line.hasOption(HELP_OPTION)) {
            printHelp(options);            
        } else if(line.hasOption(CONSUMER_KEY_OPTION) && line.hasOption(CONSUMER_SECRET_OPTION)
        		&& line.hasOption(ACCESS_TOKEN_OPTION) && line.hasOption(ACCESS_TOKEN_SECRET_OPTION)) {
    		final String consumerKeyValue = line.getOptionValue(CONSUMER_KEY_OPTION);
    		final String consumerSecretValue = line.getOptionValue(CONSUMER_SECRET_OPTION);
    		final String accessTokenValue = line.getOptionValue(ACCESS_TOKEN_OPTION);
    		final String tokenSecretValue = line.getOptionValue(ACCESS_TOKEN_SECRET_OPTION);
    		
    		final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(consumerKeyValue, consumerSecretValue);
    		final CompaniesApiClient client = factory.createCompaniesApiClient(accessTokenValue, tokenSecretValue);
    		
    		if(line.hasOption(ID_OPTION)) {
    			String idValue = line.getOptionValue(ID_OPTION);
    			System.out.println("Fetching profile for company with id:" + idValue);
    			Company company = client.getCompanyById(idValue, EnumSet.allOf(CompanyField.class));
    			printResult(company);
    			Products companyProducts = client.getCompanyProducts(idValue, EnumSet.allOf(ProductField.class));
    			for (Product product : companyProducts.getProductList()) {
					printResult(product);
				}
    		} else {
    			System.out.println("Fetching profile for company. LinkedIn");
    			Company company = client.getCompanyByUniversalName("linkedin", EnumSet.allOf(CompanyField.class));
    			printResult(company);
    		}
        } else {
            printHelp(options);
        }
    }
	
	private static void printResult(Product product) {
		System.out.println("================================");
		System.out.println("Name:" + product.getName());
		System.out.println("Description:" + product.getDescription());
		System.out.println("Features:" + product.getFeatures());
		System.out.println("URL:" + product.getWebsiteUrl());
	}

	/**
     * Build command line options object.
     */
    private static Options buildOptions() {
       
        Options opts = new Options();
        
        String helpMsg = "Print this message.";
        Option help = new Option(HELP_OPTION, helpMsg);
        opts.addOption(help);

        String consumerKeyMsg = "You API Consumer Key.";
        OptionBuilder.withArgName("consumerKey");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(consumerKeyMsg);
        Option consumerKey = OptionBuilder.create(CONSUMER_KEY_OPTION);
        opts.addOption(consumerKey);
        
        String consumerSecretMsg = "You API Consumer Secret.";
        OptionBuilder.withArgName("consumerSecret");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(consumerSecretMsg);
        Option consumerSecret = OptionBuilder.create(CONSUMER_SECRET_OPTION);
        opts.addOption(consumerSecret);
        
        String accessTokenMsg = "You OAuth Access Token.";
        OptionBuilder.withArgName("accessToken");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(accessTokenMsg);
        Option accessToken = OptionBuilder.create(ACCESS_TOKEN_OPTION);
        opts.addOption(accessToken);
        
        String tokenSecretMsg = "You OAuth Access Token Secret.";
        OptionBuilder.withArgName("accessTokenSecret");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(tokenSecretMsg);
        Option accessTokenSecret = OptionBuilder.create(ACCESS_TOKEN_SECRET_OPTION);
        opts.addOption(accessTokenSecret);
        
        String idMsg = "ID of the user whose profile is to be fetched.";
        OptionBuilder.withArgName("id");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(idMsg);
        Option id = OptionBuilder.create(ID_OPTION);
        opts.addOption(id);
        
        return opts;
    }
    
    /**
     * Print help and usage.
     */
    private static void printHelp(Options options) {
        int width = 80;
        String syntax = CompaniesApiExample.class.getName() + " <options>";
        String header = MessageFormat.format("\nThe -{0}, -{1}, -{2} and -{3} options are required. All others are optional.", CONSUMER_KEY_OPTION, CONSUMER_SECRET_OPTION, ACCESS_TOKEN_OPTION, ACCESS_TOKEN_SECRET_OPTION);
        String footer = "";
        new HelpFormatter().printHelp(width, syntax, header, options, footer, false);
    }
    
    /**
     * Print the result of API call.
     */
    private static void printResult(Company company) {
    	System.out.println("================================");
    	System.out.println("Name:" + company.getName());
    	System.out.println("Description:" + company.getDescription());
    	System.out.println("Size:" + company.getSize());
    	System.out.println("Industry:" + company.getIndustry());
    	System.out.println("Picture:" + company.getLogoUrl());
	}
}
