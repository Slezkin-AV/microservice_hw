package otus;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;

import java.util.Map;

@Slf4j
public class SrvPrincipalExtractor{//} implements PrincipalExtractor {

//    @Override
//    public Object extractPrincipal(Map<String, Object> map) {
//        log.info("PrincipalExtractor");
//        map.forEach(((k,v) -> log.info(k, v)));
//        return map.get("name");
//    }
}