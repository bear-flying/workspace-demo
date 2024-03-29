package com.jiangyu.mediator;

/**
 * 调停者模式\中介者模式设计模式：
 *
 * 包装了一系列对象相互作用的方式，使得这些对象不必相互明显作用。从而使他们可以松散偶合。
 * 当某些对象之间的作用发生改变时，不会立即影响其他的一些对象之间的作用。
 * 保证这些作用可以彼此独立的变化。调停者模式将多对多的相互作用转化为一对多的相互作用。
 *
 * 松散耦合：
 * 调停者模式通过把多个同事对象之间的交互封装到调停者对象里面，从而使得同事对象之间松散耦合，基本上可以做到互补依赖。
 * 这样一来，同事对象就可以独立地变化和复用，而不再像以前那样“牵一处而动全身”了。
 *
 * 集中控制交互：
 * 多个同事对象的交互，被封装在调停者对象里面集中管理，使得这些交互行为发生变化的时候，只需要修改调停者对象就可以了，
 * 当然如果是已经做好的系统，那么就扩展调停者对象，而各个同事类不需要做修改。
 *
 * 多对多变成一对多：
 * 没有使用调停者模式的时候，同事对象之间的关系通常是多对多的，引入调停者对象以后，
 * 调停者对象和同事对象的关系通常变成双向的一对多，这会让对象的关系更容易理解和实现。
 *
 * 调停者模式的缺点：
 * 调停者模式的一个潜在缺点是，过度集中化。如果同事对象的交互非常多，而且比较复杂，
 * 当这些复杂性全部集中到调停者的时候，会导致调停者对象变得十分复杂，而且难于管理和维护。
 */
public class Client {

    public static void main(String[] args) {
        //调停者  主板
        MainCard mainCard = new MainCard();

        CDDriver cd = new CDDriver();
        cd.setMediator(mainCard);
        CPU cpu = new CPU();
        cpu.setMediator(mainCard);
        VideoCard video = new VideoCard(mainCard);
        SoundCard sound = new SoundCard(mainCard);


        mainCard.setCd(cd);
        mainCard.setCpu(cpu);
        mainCard.setSound(sound);
        mainCard.setVideo(video);


        //看电影
        cd.readCD("制作面条的画面,舌尖上的中国2");


    }

}
