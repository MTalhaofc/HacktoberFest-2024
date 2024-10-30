import asyncio
from playwright.async_api import async_playwright

async def scrape_titles(url):
    async with async_playwright() as playwright:
        # Launch the browser
        browser = await playwright.chromium.launch(headless=False)
        page = await browser.new_page()

        # Navigate to the specified URL
        await page.goto(url)

        # Scrape article titles (example using h2 tags)
        titles = await page.query_selector_all('h2')
        for title in titles:
            text = await title.inner_text()
            print(text)

        # Close the browser
        await browser.close()

# Example usage
url = 'https://news.ycombinator.com/'  # Change to the desired website
asyncio.run(scrape_titles(url))
