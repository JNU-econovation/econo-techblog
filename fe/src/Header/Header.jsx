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
        <NavItem navName="Home" link="/" />
        <NavItem navName="Tech" link="/tech" />
        <NavItem navName="Culture" link="/culture" />
        <NavItem navName="Trouble Shooting" link="/troubleshooting" />
      </ul>
      <div className="header-right-box">
        <Search />
        <LoginButton />
      </div>
    </header>
  );
}

export default Header;
