package com.project.ecommerce.config;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecretManagerConfig {
    private final String secretName = "prod"; // Replace with your secret name
    private final Region region = Region.of("us-west-2"); // Replace with your AWS region

    public SecretsManagerClient secretsManagerClient() {
        return SecretsManagerClient.builder()
                .region(region)
                .build();
    }

    public String getSecret() {
        GetSecretValueRequest valueRequest = GetSecretValueRequest.builder()
                .secretId(secretName)
                .build();

        SecretsManagerClient client = secretsManagerClient();
        GetSecretValueResponse valueResponse = client.getSecretValue(valueRequest);
        return valueResponse.secretString(); // You can parse this string into a JSON or properties object as needed
    }
}
