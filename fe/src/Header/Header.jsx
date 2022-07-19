import React from 'react';
import LoginButton from './components/LoginButton';
import NavItem from './components/NavItem';
import Search from './components/Search';
import testLogo from './img/test_logo.png';
import './Header.css';

function Header() {
  return (
    <header className="header">
      <img className="header-logo" src={testLogo} alt="econovation logo" />
      <ul className="header-nav-button-box">
        <NavItem navName="Home" />
        <NavItem navName="Tech" />
        <NavItem navName="Culture" />
        <NavItem navName="Trouble Shooting" />
      </ul>
      <div className="header-right-box">
        <Search />
        <LoginButton />
      </div>
    </header>
  );
}

export default Header;
