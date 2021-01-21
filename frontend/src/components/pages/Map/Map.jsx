import React, { useState } from 'react';
import './Map.css';
import  './Map';
import ModalForm from '../../Modal';
import { get } from 'lodash';
import bg from '../../../images/bg.svg';
import markerIMG from '../../../images/marker.png';
import $ from 'jquery';


function Map(props) {
  const [correct, setCorrect] = useState(true);
  const [modal, setModal] = useState(false);


  const activeModal = () => {
    setModal(!modal);
  };

  const markers = Object.keys(props.pazzles).map(key => 
    <a href="/pazzle" className="quest-marker" style={props.pazzles[key].styles}>
      <img src={markerIMG} alt="..." />
      <span className="quest-marker__questNumber">{props.pazzles[key].questNumber}</span>
    </a>
  )

  return (
      <div className="quest-main__map">
      <button id="toggleFullScreen" data-toggle-fullscreen>Toggle Fullscreen</button>
        <div className="mapHolder">
          <div className="mapImg">
            <img src={bg} alt="..." className="quest-main-img" />
            {markers}
          </div>
        </div>
      </div>
  );
}

export default Map;
