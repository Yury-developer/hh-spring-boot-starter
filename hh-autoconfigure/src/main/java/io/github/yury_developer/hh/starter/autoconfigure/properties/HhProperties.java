package io.github.yury_developer.hh.starter.autoconfigure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for HH.ru API client.
 * <p>
 * Usage in application.yml:
 * <pre>
 * hh:
 *   api:
 *     base-url: https://api.hh.ru
 *     connect-timeout: 5000
 *     read-timeout: 10000
 *     user-agent: MyApp/1.0
 *     enabled: true
 * </pre>
 */
@Data
@ConfigurationProperties(prefix = "hh.api")
public class HhProperties {

    /**
     * Base URL for HH.ru API
     */
    private String baseUrl = "https://api.hh.ru";

    /**
     * Connection timeout in milliseconds
     */
    private int connectTimeout = 5000;

    /**
     * Read timeout in milliseconds
     */
    private int readTimeout = 10000;

    /**
     * User-Agent header value (required by HH.ru API)
     */
    private String userAgent = "SpringBoot-HH-Client/1.0";

    /**
     * Whether the HH.ru client is enabled
     */
    private boolean enabled = true;

    /**
     * Default area code (113 = Russia)
     */
    private int defaultArea = 113;

    /**
     * Default number of items per page
     */
    private int defaultPerPage = 20;
}
