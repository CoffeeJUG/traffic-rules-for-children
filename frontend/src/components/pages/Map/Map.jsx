import React, { useState } from 'react';
import  '../Canvas/Canvas';
import './Map.css';
import ModalForm from '../../Modal';
import { get } from 'lodash';
import { quests } from '../../../constants';
import bg from '../../../images/bg.jpg';
import marker1 from '../../../images/marker1.png';
import marker2 from '../../../images/marker2.png';


function Map() {
  const [correct, setCorrect] = useState(true);
  const [modal, setModal] = useState(false);

  const description = get(quests, 'quest1.description', '');

  const activeModal = () => {
    setModal(!modal);
  };



  return (
      <div>
      <div className="quest-main__map">
          <img src={bg} alt="..." className="quest-main-img" />
          <a href="/pazzle"><img src={marker1} alt="..." className="quest-marker1-img" /></a>
          <a href="/pazzle-1"><img src={marker2} alt="..." className="quest-marker2-img" /></a>
      </div>
    <button id="toggleFullScreen" data-toggle-fullscreen>Toggle Fullscreen</button>
      </div>
  );
}

export default Map;
