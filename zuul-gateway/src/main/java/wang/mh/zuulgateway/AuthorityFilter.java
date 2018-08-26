package wang.mh.zuulgateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class AuthorityFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String name = request.getParameter("name");
        if (StringUtils.isEmpty(name)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            log.warn("authenticate failed");
            return null;
        }
        log.info("request uri : {}, user name : {}", request.getRequestURI(), name);
        return null;
    }
}
