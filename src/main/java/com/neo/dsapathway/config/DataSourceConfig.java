package com.neo.dsapathway.config;

import com.azure.core.credential.TokenCredential;
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

        TokenCredential credential = getCredential();
        String accessToken = credential.getToken(
                new TokenRequestContext().setScopes(Collections.singletonList("https://database.windows.net/.default"))
        ).block().getToken();

        dataSource.setAccessToken(accessToken);
        return dataSource;
    }

    private TokenCredential getCredential() {
        // Use DefaultAzureCredential if running in Azure, else AzureCliCredential for local
        if (isRunningOnAzure()) {
            return new DefaultAzureCredentialBuilder().build();
        } else {
            return new AzureCliCredentialBuilder().build();
        }
    }

    private boolean isRunningOnAzure() {
        boolean runningOnAzure = System.getenv("WEBSITE_INSTANCE_ID") != null;
        System.out.println("Running on Azure: " + runningOnAzure);
        return runningOnAzure;
    }

}
