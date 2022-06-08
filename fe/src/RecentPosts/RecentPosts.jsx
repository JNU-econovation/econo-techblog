import React, { useState } from 'react';
import './RecentPosts.css';
import more from './img/more.png';

import Post from './components/Post';

const RecentPosts = function () {
  const [activeNav, setActiveNav] = useState('1');
  const onClick = (e) => {
    setActiveNav(e.target.id);
  };
  return (
    <div className="recent-posts">
      <h2>Recent Posts</h2>
      <div className="posts-box">
        <div className="nav">
          <button
            type="button"
            id="1"
            onClick={onClick}
            className={activeNav === '1' ? 'nav-item active' : 'nav-item'}
          >
            Tech
          </button>
          <button
            type="button"
            id="2"
            onClick={onClick}
            className={activeNav === '2' ? 'nav-item active' : 'nav-item'}
          >
            Culture
          </button>
          <button
            type="button"
            id="3"
            onClick={onClick}
            className={activeNav === '3' ? 'nav-item active' : 'nav-item'}
          >
            Trouble Shooting
          </button>
        </div>
        <button className="more-btn" type="button">
          <span className="more-text">more</span>
          <img className="more-img" src={more} alt="more" />
        </button>
        <div className="post-list">
          <Post />
          <Post />
          <Post />
          <Post />
          <Post />
          <Post />
        </div>
      </div>
    </div>
  );
};

export default RecentPosts;
