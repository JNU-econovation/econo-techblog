import React from 'react';
import HomeBanner from '../HomeBanner/HomeBanner';
import RecentPosts from '../RecentPosts/RecentPosts';
import HomeOffical from './HomeOffical';
import BottomBanner from '../BottomBanner/BottomBanner';
import Footer from '../Footer/Footer';

const Main = function () {
  return (
    <div className="main-page">
      <HomeBanner />
      <HomeOffical />
      <RecentPosts />
      <BottomBanner />
      <Footer />
    </div>
  );
};

export default Main;
