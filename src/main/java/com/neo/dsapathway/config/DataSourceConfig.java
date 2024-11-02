package com.neo.dsapathway.config;

import com.azure.core.credential.TokenRequestContext;
import com.azure.identity.AzureCliCredentialBuilder;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.util.Collections;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setServerName("dsapathway.database.windows.net");
        dataSource.setDatabaseName("dsapathway");
        dataSource.setAuthentication("ActiveDirectoryManagedIdentity"); // Enable MSI for Azure

        // Create TokenRequestContext with the required scope
        TokenRequestContext tokenRequestContext = new TokenRequestContext()
                .setScopes(Collections.singletonList("https://database.windows.net/.default"));

        // Conditional logic for token acquisition
        String accessToken;
        if (isRunningOnAzure()) {
            // Fetch token via Managed Identity in Azure
            accessToken = new DefaultAzureCredentialBuilder().build()
                    .getToken(tokenRequestContext)
                    .block()
                    .getToken();
        } else {
            // Use Azure CLI to fetch token locally
            accessToken = new AzureCliCredentialBuilder().build()
                    .getToken(tokenRequestContext)
                    .block()
                    .getToken();
        }

        dataSource.setAccessToken(accessToken);
        return dataSource;
    }

    private boolean isRunningOnAzure() {
        // Detects if running in Azure environment, on Azure apps, azure function etc
        return System.getenv("WEBSITE_INSTANCE_ID") != null;
    }

}
