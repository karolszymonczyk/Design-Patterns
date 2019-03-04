package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelBuilder;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelProperties;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelPropertyKey;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.spy.TestSpySocialChannel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCensorTest extends AbstractSocialChanneldDecoratorTest {

  @Test
  public void testWordCensor() {
    // Create the builder
    SocialChannelBuilder builder = createTestSpySocialChannelBuilder();

    // create a spy social channel
    SocialChannelProperties props = new SocialChannelProperties().putProperty(SocialChannelPropertyKey.NAME, TestSpySocialChannel.NAME);
    SocialChannel channel = builder.with(new WordCensor("Microsoft")).getDecoratedChannel(props);

    // Now call channel.deliverMessage
    channel.deliverMessage("Microsoft Windows is great!!");

    // Spy channel. Should get the one created before
    TestSpySocialChannel spyChannel = (TestSpySocialChannel) builder.buildChannel(props);
    assertEquals("### Windows is great!!", spyChannel.lastMessagePublished());
  }
}
