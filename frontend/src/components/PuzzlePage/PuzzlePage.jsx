import React from 'react';
import './PuzzlePage.css';

let PuzzlePage = () => {
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
          <img src="/pictures/road-traffic-bg-img.png" alt="road-traffic"></img>
        </div>

        <div className="puzzle-page__choose">
          <div className="puzzle-page__variant puzzle-variant">
            <img
              src="pictures/pedestrian-lights.png"
              alt="pedestrian-lights"
              className="puzzle-variant__image"
            />
            <a href="/" className="puzzle-variant__puzzle puzzle">
              <div className="puzzle__color puzzle__color--green"></div>
              <div className="puzzle__color puzzle__color--red"></div>
            </a>
          </div>
          <div className="puzzle-page__variant puzzle-variant">
            <img
              src="pictures/car-lights.svg"
              alt="car-lights"
              className="puzzle-variant__image"
            />
            <a href="/" className="puzzle-variant__puzzle puzzle">
              <div className="puzzle__color puzzle__color--green"></div>
              <div className="puzzle__color puzzle__color--yellow"></div>
              <div className="puzzle__color puzzle__color--red"></div>
            </a>
          </div>
          <a href="/" className="puzzle-page__button">
            Готово
          </a>
        </div>
      </div>
    </div>
  );
};

export default PuzzlePage;
