package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

public class WordCensor extends SocialChannelDecorator{

  private String word = "";

  public WordCensor(String word){
    this.word = word;
  }

  @Override
  public void deliverMessage(String message) {
    if (message.contains(word)) {
      message = message.replace(word, "###");
    }
    delegate.deliverMessage(message);
  }
}
