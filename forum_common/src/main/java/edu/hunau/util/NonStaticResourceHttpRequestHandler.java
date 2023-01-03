package edu.hunau.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;

/**
 * 非静态资源http请求处理程序
 *
 * @author ND_LJQ
 * @date 2023/01/03
 */


@Component
public class NonStaticResourceHttpRequestHandler extends ResourceHttpRequestHandler {
    public final static String ATTR_FILE = "NON-STATIC-FILE";

    @Override
    protected Resource getResource(HttpServletRequest request) {
        final Path filePath = (Path) request.getAttribute(ATTR_FILE);
        return new FileSystemResource(filePath);
    }

}
