import React from 'react';
import './PuzzlePage.css';

let PuzzlePage = () => {
  return (
    <div className="puzzle-page">
      <div className="puzzle-page__img"></div>
      <div className="puzzle-page__puzzle">
        <div className="puzzle-page__choose">
          <div className="puzzle-page__variant puzzle-variant">
            <img
              src="../../images/images/pedestrian-lights.svg"
              alt="pedestrian-lights"
              className="puzzle-variant__image"
            />
            <a href="/" className="puzzle-variant__puzzle puzzle">
              <div className="puzzle__color"></div>
              <div className="puzzle__color"></div>
              <div className="puzzle__color"></div>
            </a>
          </div>
          <div className="puzzle-page__variant puzzle-variant">
            <img
              src="../../images/images/pedestrian-lights.svg"
              alt="pedestrian-lights"
              className="puzzle-variant__image"
            />
            <a href="/" className="puzzle-variant__puzzle puzzle">
              <div className="puzzle__color"></div>
              <div className="puzzle__color"></div>
              <div className="puzzle__color"></div>
            </a>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PuzzlePage;
