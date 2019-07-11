package schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

//@Component
public class ScheduledTasks {
    @Scheduled(fixedRate = 1000)
    public void test(){
        //执行任务调度的方法
        System.out.println("RUNNING......");
    }
}
