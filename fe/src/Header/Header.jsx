import React from 'react';
import LoginButton from './components/LoginButton';
import NavItem from './components/NavItem';
import Search from './components/Search';
import testLogo from './img/test_logo.png';
import './Header.css';

function Header() {
  return (
    <div className="header">
      <img alt="econovation logo" src={testLogo} />
      <div className="header-nav-button-box">
        <NavItem />
        <NavItem />
        <NavItem />
        <NavItem />
      </div>
      <div className="header-right-box">
        <Search />
        <LoginButton />
      </div>
    </div>
  );
}

export default Header;
