/**
 * Copyright (c) 2012-2017, jcabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jcabi.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

/**
 * Test case for {@link VerboseThreads}.
 * @author Yegor Bugayenko (yegor256@gmail.com)
 * @version $Id: e05fc698c52e8955cb25ae2ad87e266632ea8d1d $
 * @since 0.1
 */
@SuppressWarnings("PMD.DoNotUseThreads")
public final class VerboseThreadsTest {

    /**
     * VerboseThreads can create new threads on demand.
     * @throws Exception If something goes wrong
     */
    @Test
    public void instantiatesThreadsOnDemand() throws Exception {
        final ExecutorService service = Executors
            .newSingleThreadExecutor(new VerboseThreads("foo"));
        service.execute(
            () -> {
                throw new IllegalArgumentException("oops");
            }
        );
        TimeUnit.SECONDS.sleep(1L);
        service.shutdown();
    }

    /**
     * VerboseThreads can log exceptions with {@link ExecutorService#submit()}.
     * @throws Exception If something goes wrong
     */
    @Test
    public void logsWhenThreadsAreNotDying() throws Exception {
        final ExecutorService service = Executors
            .newSingleThreadExecutor(new VerboseThreads(this));
        final Future<?> future = service.submit(
            (Runnable) () -> {
                throw new IllegalArgumentException("boom");
            }
        );
        while (!future.isDone()) {
            TimeUnit.SECONDS.sleep(1L);
        }
        service.shutdown();
    }

}