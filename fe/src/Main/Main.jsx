import React from 'react';
import HomeBanner from '../HomeBanner/HomeBanner';
import RecentPosts from '../RecentPosts/RecentPosts';
import HomeOffical from './HomeOffical';

const Main = function () {
  return (
    <div className="main-page">
      <HomeBanner />
      <HomeOffical />
      <RecentPosts />
    </div>
  );
};

export default Main;
