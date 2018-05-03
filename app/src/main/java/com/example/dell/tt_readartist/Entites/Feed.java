package com.example.dell.tt_readartist.Entites;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell on 4/23/2018.
 */
  @Root(name = "rss", strict = false)
    public class Feed implements Serializable {
        @Element(name = "channel")
        private Channel mChannel;

        public Channel getmChannel() {
            return mChannel;
        }

        public Feed() {
        }

        public Feed(Channel mChannel) {
            this.mChannel = mChannel;
        }
    }

