import LoginButton from './components/LoginButton';
import NavItem from './components/NavItem';
import test_logo from './img/test_logo.png';
import './Header.css';


const Header = () => {
    return (
        <div className="header">
            <img alt="econovation logo" src={test_logo}/>
            <div className="header-nav-button-box">
                <NavItem />
                <NavItem />
                <NavItem />
                <NavItem />
            </div>
            <div className="header-right-box">
                <LoginButton />
            </div>
        </div>
    )
}

export default Header;