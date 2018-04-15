package com.mywork.service.zuulserver;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
@Component
public class SimpleRouteFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(SimpleRouteFilter.class);

  @Override
  public String filterType() {
    return "route";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
    log.info(RequestContext.getCurrentContext().getRequest().getRequestURI().split("/")[1]);
    log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
    HttpServletResponse servletResponse = RequestContext.getCurrentContext().getResponse();
    return null;
  }

}
