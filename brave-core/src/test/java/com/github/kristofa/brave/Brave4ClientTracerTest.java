package com.github.kristofa.brave;

import brave.Tracer;

public class Brave4ClientTracerTest extends ClientTracerTest {
  @Override Brave newBrave() {
    return TracerAdapter.newBrave(Tracer.newBuilder()
        .clock(new AnnotationSubmitter.DefaultClock()::currentTimeMicroseconds)
        .localEndpoint(ZIPKIN_ENDPOINT)
        .clock(clock::currentTimeMicroseconds)
        .reporter(spans::add).build());
  }
}
