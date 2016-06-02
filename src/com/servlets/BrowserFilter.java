package com.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class BrowserFilter implements Filter
{
    // Be default, support all GWT-capable browsers
    // Assume any version recent enough except IE
    private static final String[] DEFAULT_BROWSERS =
    { "Chrome", "IE" };
 
    // Filter param keys
    public static final String KEY_BROWSER_IDS = "browserIds";
    public static final String KEY_BAD_BROWSER_URL = "badBrowserUrl";
 
    // Configured params
    private String[] browserIds;
    private String badBrowserUrl;
 
    @Override
    public void init(FilterConfig cfg) throws ServletException
    {	
    	
        String ids = cfg.getInitParameter(KEY_BROWSER_IDS);
        this.browserIds = (ids != null)?ids.split(","):DEFAULT_BROWSERS;
        System.out.println( this.browserIds);
        badBrowserUrl = "http://www.youtube.com/watch?v=KwcO9WlIggw";
        System.out.println( this.badBrowserUrl);
        if (badBrowserUrl == null)
        {
            throw new IllegalArgumentException("BrowserFilter requires param badBrowserUrl");
        }
    }
 
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
        throws IOException, ServletException
    {
    	 System.out.println("doFilter()");
        String userAgent = ((HttpServletRequest) req).getHeader("User-Agent");
        for (String browser_id : browserIds)
        {
            if (userAgent.contains(browser_id))
            {
                chain.doFilter(req, resp);
                return;
            }
        }
        // Unsupported browser
        ((HttpServletResponse) resp).sendRedirect(this.badBrowserUrl);
    }
 
    @Override
    public void destroy()
    {
        this.browserIds = null;
    }
}
