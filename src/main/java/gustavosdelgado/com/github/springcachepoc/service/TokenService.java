package gustavosdelgado.com.github.springcachepoc.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    private Token token;

    public Token createToken() {
        log.info("Creating token...");
        simulateSlowDBRetrieval();
        this.token = new Token();
        token.setAccessToken("accessToken");
        token.setCrationDateTime(LocalDateTime.now());
        return token;
    }

    @CachePut(cacheNames = "token")
    public Token updateToken() {
        createToken();
        log.info("Updating token: {}", token.getCrationDateTime());
        return token;
    }

    @Cacheable(cacheNames = "token")
    public Token getToken() {
        log.info("Getting token without cache...");
        simulateSlowDBRetrieval();
        return this.token;
    }

    private void simulateSlowDBRetrieval() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
