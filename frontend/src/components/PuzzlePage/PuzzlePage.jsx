import React from 'react';
import { Component } from 'react';
import Modal from '../Modal/Modal';
import './PuzzlePage.css';

class PuzzlePage extends Component {
  render() {
    return (
      <div className="puzzle-page">
        <div className="header">
          <a className="header__link link" href="/">
            Logo
          </a>
          <nav className="navigation">
            <a className="navigation__link link" href="/">
              Карта
            </a>
            <a className="navigation__link link" href="/">
              Кращі гравці
            </a>
            <a className="navigation__link link" href="/">
              Мій профіль
            </a>
          </nav>
        </div>

        <div className="puzzle-page__puzzle">
          <div className="puzzle-page__image">
            <img
              src="/pictures/road-traffic-bg-img.png"
              alt="road-traffic"
            ></img>

            <div className="puzzle-page__instruction">
              Встав кольори в правильному порядку.
            </div>
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
            <a href="/" className="puzzle-page__button" onClick="sendAnswer()">
              Готово
            </a>
          </div>
        </div>
      </div>
    );
  }
}

export default PuzzlePage;
