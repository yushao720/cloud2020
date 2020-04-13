package com.guozeyu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class myLB implements LoadBalancer {

    AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;

        do{

            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1 ; //防止current越界


        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("next : " + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
