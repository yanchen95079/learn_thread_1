package com.yc.thread.pojo;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName Chain
 * @Date 2019/05/10 14:36
 */
public class Chain extends Thread{
    private List<ChainBaseHandler> handlers;
    /**
     * 用来表示handlers的游标
     */
    private int index = -1;

    public  Chain(List<ChainBaseHandler> handlers){
        this.handlers = handlers;
    }

    @Override
    public void run() {
        this.proceed();
    }

    /**
     * 通过index自增 调用excute实现递归  遍历整个handlers
     */
    public void proceed(){
        if(index == handlers.size() - 1){
            return;
        }
        handlers.get(++index).execute(this);
    }


}
