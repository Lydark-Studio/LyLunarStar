/*
 * Copyright (c) 2022. LyDark Studio MIT License
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.lymarket.lunarstar.lunar;

import net.md_5.bungee.api.Favicon;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class LunarStar implements Listener {
    
    
    @EventHandler
    public void onProxyPing( ProxyPingEvent event ){
        ServerPing prev = event.getResponse( );
        ServerPing copy = new LunarClientServerPing( prev.getVersion( ) , prev.getPlayers( ) , prev.getDescriptionComponent( ) , prev.getFaviconObject( ) );
        copy.getModinfo( ).setType( prev.getModinfo( ).getType( ) );
        copy.getModinfo( ).setModList( prev.getModinfo( ).getModList( ) );
        event.setResponse( copy );
    }
    
    static class LunarClientServerPing extends ServerPing {
        private final String lcServer = "sanity";
        
        LunarClientServerPing( ServerPing.Protocol version , ServerPing.Players players , BaseComponent description , Favicon favicon ){
            super( version , players , description , favicon );
        }
    }
}