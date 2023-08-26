package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeComponent implements Component{

    private Component component;

    public TimeComponent(Component component) {
        this.component = component;
    }


    @Override
    public String operation() {

        log.info("call TimeComponent");
        long startTime = System.currentTimeMillis();
        String result = component.operation();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("end TimeDecorator, resultTime={}ms", resultTime);

        return result;
    }
}
