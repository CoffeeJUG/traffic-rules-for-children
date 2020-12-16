import React from 'react';
import './Navbar.css';

function Navbar() {
  return (
    <div className="header">
      <a className="header__link link" href="/mainPage">
        Logo
      </a>
      <nav className="navigation">
        <a className="navigation__link link" href="/map">
          Карта
        </a>
        <a className="navigation__link link" href="/bestPlayers">
          Кращі гравці
        </a>
        <a className="navigation__link link" href="/profile">
          Мій профіль
        </a>
      </nav>
    </div>
  );
}

export default Navbar;
