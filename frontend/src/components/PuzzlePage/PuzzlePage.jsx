import React from 'react';
import { Component } from 'react';
import './PuzzlePage.css';
import Instruction from '../pages/Instruction/Instruction';

class PuzzlePage extends Component {
  render() {
    return (
      <div className="puzzle-page">
        <div className="puzzle-page__puzzle">
          <div className="puzzle-page__image">
            <img
              src="/pictures/road-traffic-bg-img.png"
              alt="road-traffic"
            ></img>

            <Instruction></Instruction>
          </div>

          <div className="puzzle-page__choose">
            <div className="puzzle-page__variant puzzle-variant">
              <div className="puzzle-variant__image">
                <img
                  src="pictures/pedestrian-lights.png"
                  alt="pedestrian-lights"
                />
                <div className="empty empty--top"></div>
                <div className="empty empty--bottom"></div>
              </div>

              <div className="puzzle-variant__puzzle puzzle">
                <div
                  className="puzzle__color puzzle__color--green draggable"
                  draggable="true"
                ></div>
                <div
                  className="puzzle__color puzzle__color--red draggable"
                  draggable="true"
                ></div>
              </div>
            </div>
            <div className="puzzle-page__variant puzzle-variant">
              <div className="puzzle-variant__image car-light__image">
                <img
                  src="pictures/car-lights.svg"
                  alt="car-lights"
                  className="puzzle-variant__image"
                />
                <div className="empty sec_empty--top"></div>
                <div className="empty sec_empty--middle"></div>
                <div className="empty sec_empty--bottom"></div>
              </div>
              <div className="puzzle-variant__puzzle puzzle">
                <div
                  className="puzzle__color puzzle__color--green draggable"
                  draggable="true"
                ></div>
                <div
                  className="puzzle__color puzzle__color--yellow draggable"
                  draggable="true"
                ></div>
                <div
                  className="puzzle__color puzzle__color--red draggable"
                  draggable="true"
                ></div>
              </div>
            </div>
            <a href="/" className="puzzle-page__button">
              Готово
            </a>
          </div>
        </div>
      </div>
    );
  }
}

export default PuzzlePage;
