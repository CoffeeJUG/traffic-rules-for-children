import React, { useState } from 'react';
import './Map.css';
import ModalForm from '../../Modal';
import { get } from 'lodash';
import bg from '../../../images/bg.jpg';
import markerIMG from '../../../images/marker.png';


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
        <div className="quest-main__map__background">
          <img src={bg} alt="..." className="quest-main-img" />
          {markers}
        </div>
      </div>
  );
}

export default Map;
