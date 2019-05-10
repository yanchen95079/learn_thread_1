package com.yc.thread.pojo;

import java.util.Arrays;
import java.util.List;

/**
 * @author Yanchen
 * @ClassName ChainClient
 * @Date 2019/05/10 14:36
 */
public class ChainClient {
    static class ChainHandlerA extends ChainBaseHandler {
        @Override
        protected void handlerProcess() {
            System.out.println("handler by chain a");
        }
    }

    static class ChainHandlerB extends ChainBaseHandler {
        @Override
        protected void handlerProcess() {
            System.out.println("handler by chain b");
        }
    }

    static class ChainHandlerC extends ChainBaseHandler {
        @Override
        protected void handlerProcess() {
            System.out.println("handler by chain c");
        }
    }

    public static void main(String[] args) {
        /**
         * 声明HandlerList关系链 通过数组顺序排序
         * 不再像之前那样手动给当前Handler中的NextHandler设置值
         * 同样每个chain中间没有相互的依赖 实现解耦
         */
        List<ChainBaseHandler> handlerList = Arrays.asList(
                new ChainHandlerA(),
                new ChainHandlerB(),
                new ChainHandlerC()
        );


        Chain chain = new Chain(handlerList);
        //OLD
       // chain.proceed();
        //new
        chain.start();
        System.out.println("END");
    }

}
