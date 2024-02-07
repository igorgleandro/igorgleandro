//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.academiadecodigo.simplegraphics.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.academiadecodigo.simplegraphics.graphics.Canvas;

public class Mouse implements MouseListener, MouseMotionListener {
    MouseHandler handler;
    List<MouseEventType> mouseEventArrayList;

    public Mouse(MouseHandler var1) {
        Canvas.getInstance().addMouseListener(this);
        Canvas.getInstance().addMouseMotionListener(this);
        this.handler = var1;
        this.mouseEventArrayList = new ArrayList();
    }

    /**
     * listens for a particular mouse event
     * @param eventType
     */
    public void addEventListener(MouseEventType eventType) {
        this.mouseEventArrayList.add(eventType);
    }

    /**
     * removes a previously added mouse event
     * @param eventType
     */
    public void removeEventListener(MouseEventType eventType) {
        this.mouseEventArrayList.remove(eventType);
    }

    public void mouseClicked(MouseEvent var1) {
        if (this.handler != null) {
            Iterator var2 = this.mouseEventArrayList.iterator();

            while(var2.hasNext()) {
                MouseEventType var3 = (MouseEventType)var2.next();
                if (var3 == MouseEventType.MOUSE_CLICKED) {
                    this.handler.mouseClicked(new org.academiadecodigo.simplegraphics.mouse.MouseEvent((double)var1.getX(), (double)var1.getY(), MouseEventType.MOUSE_CLICKED));
                }
            }
        }

    }

    public void mouseMoved(MouseEvent var1) {
        if (this.handler != null) {
            Iterator var2 = this.mouseEventArrayList.iterator();

            while(var2.hasNext()) {
                MouseEventType var3 = (MouseEventType)var2.next();
                if (var3 == MouseEventType.MOUSE_MOVED) {
                    this.handler.mouseMoved(new org.academiadecodigo.simplegraphics.mouse.MouseEvent((double)var1.getX(), (double)var1.getY(), MouseEventType.MOUSE_MOVED));
                }
            }
        }

    }

    public void mousePressed(MouseEvent var1) {
    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mouseDragged(MouseEvent var1) {
    }
}
