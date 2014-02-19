package edu.ycp.cs320.movethesquare.controllers;

import edu.ycp.cs320.movethesquare.model.Game;
import edu.ycp.cs320.movethesquare.model.Square;

public class GameController {
	public void computeSquareMoveDirection(Game game, Square square, double mouseX, double mouseY) {
		if (mouseX > 0 && mouseX < game.getWidth() - 1 && mouseY > 0 && mouseY < game.getHeight()) {
			double dx = mouseX - (square.getX() + square.getWidth()/2);
			double dy = mouseY - (square.getY() + square.getHeight()/2);
			
			double moveX = 0, moveY = 0;
			if (dx > 0) {
				if((square.getX() + square.getWidth()) < game.getWidth()) {
					moveX = Game.MOVE_DIST;
				} else {
					moveX = 0;
				}
			} else {
				if(square.getX() > 0) {
					moveX = -Game.MOVE_DIST;
				} else {
					moveX = 0;
				}
			}
			if (dy > 0) {
				if((square.getY() + square.getHeight()) < game.getHeight()) {
					moveY = Game.MOVE_DIST;
				} else {
					moveY = 0;
				}
			} else {
				if (square.getY() > 0) {
					moveY = -Game.MOVE_DIST;
				} else {
					moveY = 0;
				}
			}		
			
			game.setSquareDx(moveX);
			game.setSquareDy(moveY);
		} else {
			game.setSquareDx(0);
			game.setSquareDy(0);
		}
		
		System.out.println(game.getSquareDx() + " " +  game.getSquareDy());
	}

	public void moveSquare(Game model, Square square) {
		square.setX(square.getX() + model.getSquareDx());
		square.setY(square.getY() + model.getSquareDy());
	}
}
