package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelBuilder;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelProperties;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelPropertyKey;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.spy.TestSpySocialChannel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChainCensorDecoratorTest extends AbstractSocialChanneldDecoratorTest {

  @Test
  public void testChainTwoDecorators() {
    // Create the builder
    SocialChannelBuilder builder = createTestSpySocialChannelBuilder();

    // create a spy social channel
    SocialChannelProperties props = new SocialChannelProperties().putProperty(SocialChannelPropertyKey.NAME, TestSpySocialChannel.NAME);

    // Chain decorators
    SocialChannel channel = builder.
            with(new WordCensor("Microsoft")).
            with(new URLAppender("http://jpereira.eu")).
            getDecoratedChannel(props);

    channel.deliverMessage("Microsoft Windows is great!!");
    // Spy channel. Should get the one created before
    TestSpySocialChannel spyChannel = (TestSpySocialChannel) builder.buildChannel(props);
    assertEquals("### Windows is great!! http://jpereira.eu", spyChannel.lastMessagePublished());
  }
}
