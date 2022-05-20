import LoginButton from './components/LoginButton';
import test_logo from './img/test_logo.png';
import './Header.css';

const Header = () => {
    return (
        <div className="header">
            <img alt="econovation logo" src={test_logo}/>
            <div className="header-nav-button-box">
                
            </div>
            <div className="header-right-box">
                searchbar
                <LoginButton />
            </div>
        </div>
    )
}

export default Header;