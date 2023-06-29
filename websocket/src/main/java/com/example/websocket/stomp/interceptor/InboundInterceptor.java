package com.example.websocket.stomp.interceptor;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.support.ChannelInterceptor;

/**
 * @author Jeanne 2023/6/25
 **/
public class InboundInterceptor implements ChannelInterceptor {
    /**
     * 在消息发送之前调用，方法中可以对消息进行修改，如果此方法返回值为空，则不会发生实际的消息发送调用
     */
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel messageChannel) {
        SimpMessageHeaderAccessor messageAccessor = SimpMessageHeaderAccessor.wrap(message);
        StompCommand stompCommand = (StompCommand) messageAccessor.getHeader("stompCommand");
        if (StompCommand.CONNECT.equals(stompCommand)) {
            /*
             websocket的登录用户不是用web登录使用的Username
             将token解析之后，使用里面的enterprise id作为username
             */
//            JwtAuthentication authentication = (JwtAuthentication) messageAccessor.getUser();
//            UserInfo userInfo = (UserInfo) authentication.getPrincipal();
//            userInfo.setUserName(userInfo.getEnterpriseId().toString());
        }

        return message;
    }

    /**
     * 在消息发送后立刻调用，boolean值参数表示该调用的返回值
     */
    @Override
    public void postSend(Message<?> message, MessageChannel messageChannel, boolean sent) {
        // do nothing
    }

    /**
     * 1. 在消息发送完成后调用，而不管消息发送是否产生异常，在次方法中，我们可以做一些资源释放清理的工作
     * 2. 此方法的触发必须是preSend方法执行成功，且返回值不为null,发生了实际的消息推送，才会触发
     */
    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel messageChannel, boolean b, Exception e) {
        // do nothing
    }

    /**
     * 1. 在消息被实际检索之前调用，如果返回false,则不会对检索任何消息，只适用于(PollableChannels)，
     * 2. 在websocket的场景中用不到
     */
    @Override
    public boolean preReceive(MessageChannel messageChannel) {
        return true;
    }

    /**
     * 1. 在检索到消息之后，返回调用方之前调用，可以进行信息修改，如果返回null,就不会进行下一步操作
     * 2. 适用于PollableChannels，轮询场景
     */
    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel messageChannel) {
        return message;
    }

    /**
     * 1. 在消息接收完成之后调用，不管发生什么异常，可以用于消息发送后的资源清理
     * 2. 只有当preReceive 执行成功，并返回true才会调用此方法
     * 2. 适用于PollableChannels，轮询场景
     */
    @Override
    public void afterReceiveCompletion(Message<?> message, MessageChannel messageChannel, Exception e) {
        // do nothing
    }
}

