package com.czc.listen;

import jakarta.annotation.Resource;
import net.itbaima.robot.event.RobotListener;
import net.itbaima.robot.event.RobotListenerHandler;
import net.itbaima.robot.listener.MessageListener;
import net.itbaima.robot.service.RobotService;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.event.events.GroupMessageEvent;

import java.util.List;

@RobotListener
public class TestListener extends MessageListener {
    @Resource
    RobotService robotService;
    @Resource
    Bot bot;

    public TestListener(){
        super(List.of("wc", "aa", "脑残"), true);
    }

    @RobotListenerHandler
    public void handleMessage(GroupMessageEvent event){
        String s = event.getMessage().contentToString();
        if(this.invalidText(s)) {
            System.out.println("检测成功----");
            String name = event.getGroup().getName();
            long id = event.getGroup().getId();
            String avatarUrl = event.getGroup().getAvatarUrl();

            System.out.println(avatarUrl);
            System.out.println(id);
            System.out.println(name);


            robotService.sendMessageToGroup(id,"原神");
            this.atWithMessages(id,"wdnmd");
            this.recallMessage(event.getMessage());
        }
    }
}
