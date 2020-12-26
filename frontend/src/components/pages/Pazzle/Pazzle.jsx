import React from 'react';

import './Pazzle.css';

import pazzle from '../../../images/pazzle.jpg';

function Pazzle(props) {
  return (
      <div>
          <img src={pazzle} alt="..." className="pazzle-main-img" />

      </div>
  );
}

export default Pazzle;
