/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.activemq_camel_spring.routebuilder;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ComponentScanRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:foo?period=1s")
            .transform()
            .simple("Heartbeat ${date:now:yyyy-MM-dd HH:mm:ss}")
            .to("stream:out");
    }
}
