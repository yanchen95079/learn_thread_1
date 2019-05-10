package com.yc.thread.pojo;

/**
 * @author Yanchen
 * @ClassName ChainBaseHandler
 * @Date 2019/05/10 14:36
 */
public abstract class ChainBaseHandler {
    /**
     * 同样先执行自己的动作 再调用chain的proceed去遍历下一个Handler
     **/
    public void execute(Chain chain) {
        handlerProcess();
        if(chain!=null){
            chain.proceed();
        }

    } ;



    protected abstract void handlerProcess();
}