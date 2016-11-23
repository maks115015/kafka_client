package com.spr.service.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class IpUtil {

    private static final Logger logger = LogManager.getLogger(IpUtil.class);

    private IpUtil() {
    }

    private static final String[] HEADERS_TO_TRY = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR" };

    public static String getClientIpAddress(HttpServletRequest request) {
        for (String header : HEADERS_TO_TRY) {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                logger.info("ip utils - ip {} from header {}", ip, header);
                return ip.length() > 100 ? ip.substring(0,100) : ip;
            }
        }
        logger.info("ip utils no ip from header, ip - {}", request.getRemoteAddr());
        return request.getRemoteAddr().length() > 100 ? request.getRemoteAddr().substring(0, 100) :  request.getRemoteAddr();
    }
}
