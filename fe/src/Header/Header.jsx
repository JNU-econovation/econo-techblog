/* eslint-disable jsx-a11y/mouse-events-have-key-events */
/* eslint-disable react/jsx-one-expression-per-line */
/* eslint-disable jsx-a11y/no-noninteractive-element-interactions */
import React, { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

import LoginButton from './components/LoginButton';
import NavItem from './components/NavItem';
import Search from './components/Search';
import testLogo from './img/test_logo.png';
import './Header.css';
import { useLoginStateContext } from '../Context/LoginContext';

function Header() {
  // eslint-disable-next-line no-unused-vars
  const [isLogin, setIsLogin] = useState(false);
  const [isMouseOver, setIsMouseOver] = useState(false);
  const loginContext = useLoginStateContext();
  // eslint-disable-next-line no-unused-vars
  const navigate = useNavigate();

  const onLogoClick = () => {
    navigate('/');
  };

  const onMouseOverHandler = () => {
    setIsMouseOver(() => true);
  };

  const onMouseOutHandler = () => {
    setIsMouseOver(() => false);
  };

  useEffect(() => {
    if (loginContext.id === -1) {
      setIsLogin(() => false);
    } else {
      setIsLogin(() => true);
    }
  }, [loginContext]);
  return (
    <header className="header">
      <button
        type="button"
        onClick={onLogoClick}
        className="header-logo__button"
      >
        <img className="header-logo" src={testLogo} alt="econovation logo" />
      </button>
      <ul className="header-nav-button-box">
        <NavItem navName="Home" link="/" />
        <NavItem navName="Tech" link="/tech" />
        <NavItem navName="Culture" link="/culture" />
        <NavItem navName="Trouble Shooting" link="/troubleshooting" />
      </ul>
      <div className="header-right-box">
        <Search />
        {isLogin ? (
          <div onMouseOver={onMouseOverHandler} onMouseOut={onMouseOutHandler}>
            <span className="header__user-name">{loginContext.userName}</span>님
            {isMouseOver ? (
              <div>
                <Link to="/mypage">My Page</Link>
                <Link to="/write">Write</Link>
              </div>
            ) : undefined}
          </div>
        ) : (
          <LoginButton />
        )}
      </div>
    </header>
  );
}

export default Header;
